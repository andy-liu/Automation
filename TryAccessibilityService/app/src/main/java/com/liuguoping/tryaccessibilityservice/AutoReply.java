package com.liuguoping.tryaccessibilityservice;

import android.accessibilityservice.AccessibilityService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/**
 * Created by liuguoping on 2017/9/14.
 */

public class AutoReply extends AccessibilityService {
    private Handler handler = new Handler();
    private boolean hasNotify = false;
    private static boolean sIsBound = false;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType(); // 事件类型
        switch (eventType) {
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED: // 通知栏事件
                PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
                if(!pm.isScreenOn()){

                }
                openAppByNotification(accessibilityEvent);
                hasNotify = true;
                break;
            default:
                if (hasNotify) {
                    try {
                        Thread.sleep(1000); // 停1秒, 否则在微信主界面没进入聊天界面就执行了fillInputBar
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (fillInputBar("你饿不饿，我给你煮碗面吃去？")) {
                        findAndPerformAction("android.widget.Button", "发送");
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);   // 返回
                            }
                        }, 1500);

                    }
                    hasNotify = false;
                }
                break;
        }

    }

    @Override
    public void onInterrupt() {
    }

    private void openAppByNotification(AccessibilityEvent event) {
        if (event.getParcelableData() != null  && event.getParcelableData() instanceof Notification) {
            Notification notification = (Notification) event.getParcelableData();
            try {
                PendingIntent pendingIntent = notification.contentIntent;
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
    }

    private void findAndPerformAction(String widget, String text) {
        // 取得当前激活窗体的根节点
        if (getRootInActiveWindow() == null) {
            return;
        }

        // 通过文本找到当前的节点
        List<AccessibilityNodeInfo> nodes = getRootInActiveWindow().findAccessibilityNodeInfosByText(text);
        if(nodes != null) {
            for (AccessibilityNodeInfo node : nodes) {
                if (node.getClassName().equals(widget) && node.isEnabled()) {
                    node.performAction(AccessibilityNodeInfo.ACTION_CLICK); // 执行点击
                    break;
                }
            }
        }
    }

    private boolean findInputBar(AccessibilityNodeInfo rootNode, String reply) {
        int count = rootNode.getChildCount();
        for (int i = 0; i < count; i++) {
            AccessibilityNodeInfo node = rootNode.getChild(i);
            if ("android.widget.EditText".equals(node.getClassName())) {   // 找到输入框并输入文本
                fillText(node, reply);
                return true;
            }

            if (findInputBar(node, reply)) {    // 递归查找
                return true;
            }
        }
        return false;
    }

    private boolean fillInputBar(String reply) {
        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        if (rootNode != null) {
            return findInputBar(rootNode, reply);
        }
        return false;
    }

    private void fillText(AccessibilityNodeInfo node, String reply) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Bundle args = new Bundle();
            args.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE,
                    reply);
            node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, args);
        } else {
            ClipData data = ClipData.newPlainText("reply", reply);
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboardManager.setPrimaryClip(data);
            node.performAction(AccessibilityNodeInfo.ACTION_FOCUS); // 获取焦点
            node.performAction(AccessibilityNodeInfo.ACTION_PASTE); // 执行粘贴
        }
    }


}

# -*- coding:utf-8 -*-
'''
Created on 2017年6月16日

@author: liuguoping
'''
import smtplib
import time
import traceback
from email import encoders
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart, MIMEBase
from email.header import Header
from email.utils import parseaddr, formataddr

def _format_addr( s):
    name, addr = parseaddr(s)
    return formataddr((Header(name, 'utf-8').encode(), addr))

def send_email_with_attach(receiver_address, filepath, filename):
    smtp_server = 'smtp.126.com'
    sender_address = 'liuzhenyu22@126.com'
    sender_password = '565483520'
    #构建邮件内容
    msg = MIMEMultipart()
    msg['From'] = _format_addr('Python爱好者 <%s>' % sender_address)
    msg['To'] = _format_addr('就是发给你 <%s>' % receiver_address)
    msg['Subject']=Header('Android_UI_Automation_report', 'utf-8').encode()    
    # 邮件正文是MIMEText:
    msg.attach(MIMEText('send with file...', 'plain', 'utf-8'))
 
    # 添加附件就是加上一个MIMEBase，从本地读取一个图片:
    with open(filepath, 'rb') as f:
        # 设置附件的MIME和文件名，这里是png类型:
        mime = MIMEBase('html', 'html', filename= filename)
        # 加上必要的头信息:
        mime.add_header('Content-Disposition', 'attachment', filename= filename)
        mime.add_header('Content-ID', '<0>')
        mime.add_header('X-Attachment-Id', '0')
        # 把附件的内容读进来:
        mime.set_payload(f.read())
        # 用Base64编码:
        encoders.encode_base64(mime)
        # 添加到MIMEMultipart:
        msg.attach(mime)
        try:
            server=smtplib.SMTP(smtp_server,25)
            #ssl连接
            server.starttls()
            server.login(sender_address, sender_password)
            server.sendmail(sender_address, receiver_address, msg.as_string())
            return True
        except Exception:
            return False
            traceback.print_exc()
        finally:
            server.quit()

def send_email_txt( receiver_address):
    smtp_server = 'smtp.126.com'
    sender_address = 'liuzhenyu22@126.com'
    sender_password = '565483520'
    #构建邮件内容
#   msg=MIMEText('Hi\nI am a test email.','plain','utf-8')
    msg = MIMEText('<html><body><h1>Hello</h1>' +
    '<p>send by <a href="http://www.python.org">Python</a>...</p>' +
    '</body></html>', 'html', 'utf-8')
    msg['From'] = _format_addr('Python爱好者 <%s>' % sender_address)
    msg['To'] = _format_addr('就是发给你 <%s>' % receiver_address)
    msg['Subject']=Header('来自SMTP的问候……', 'utf-8').encode()
    try:
        server=smtplib.SMTP(smtp_server,25)
        #ssl连接
        server.starttls()
        server.login(sender_address, sender_password)
        server.sendmail(sender_address, receiver_address, msg.as_string())
        return True
    except Exception:
        return False
        traceback.print_exc()
    finally:
        server.quit()
        
        
        
# -*- coding:utf-8 -*-
'''
Created on 2017年6月30日

@author: liuguoping
'''
from PIL import Image, ImageFilter
import traceback

class ImageOption():
    def __init__(self):
        pass
    
    def image_zoom(self, source_image, new_image):
        try:
            # 打开一个jpg图像文件，注意是当前路径:
            im = Image.open(source_image)
            # 获得图像尺寸:
            w, h = im.size
            print('Original image size: %sx%s' % (w, h))
            # 缩放到50%:
            im.thumbnail((w//2, h//2))
            print('Resize image to: %sx%s' % (w//2, h//2))
            # 把缩放后的图像用jpeg格式保存:
            im.save(new_image, 'jpeg')
        except Exception:
            traceback.print_exc()
            
    
    def image_filter(self, source_image, new_image):
        try:
            im = Image.open(source_image)
            # 应用模糊滤镜:
            im2 = im.filter(ImageFilter.FIND_EDGES)
            im2.save(new_image, 'jpeg')
            print ('Success!')
        except Exception:
            traceback.print_exc()
            
image_option = ImageOption()
source_image = r'D:\photo\IMG_0007.jpg'
new_image = r'D:\photo\IMG_0007_filter.jpg'
# image_option.image_zoom(source_image, new_image)
image_option.image_filter(source_image, new_image)







#-*- coding:utf-8 -*-
import os
import re
import urllib
import json
import string
import socket
import requests
import random
import traceback

def dowmload_image(json_data):
    cur_dir = 'D:\spider_result'
#     cur_dir = 'E:\saving images'
    folder_name = 'pinterest' + '_'+ ''.join(random.sample(string.ascii_letters + string.digits, 8))
    image_save_path = os.path.join(cur_dir, folder_name)
    if not os.path.exists(image_save_path):
        os.mkdir(image_save_path)
    i = 0
    image_resource = json_data['resource_response']['data']
    for each in range(len(image_resource)):
        image_url = image_resource[each]['images']['orig']['url']
        print('正在下载第'+str(i+1)+'张图片，图片地址:'+image_url)
        try:
            image= requests.get(image_url, timeout=20)
        except Exception:
            print('【出错了】当前图片无法下载')
            continue
        image_path = image_save_path + '/' + 'image' + '_' + str(i) + ".jpg"
        with open(image_path,'wb') as fp:
            fp.write(image.content)
            i += 1
    print('下载完成')

headers = {'Host': 'www.pinterest.com', 
           'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0',
           'Accept': 'application/json, text/javascript, */*, q=0.01',
           'Accept-Encoding': 'gzip, deflate, br',
           'Referer': 'https://www.pinterest.com/',
           'X-Requested-With': 'XMLHttpRequest',
           'X-APP-VERSION': '64becba',
           'Cookie': '_auth=1; csrftoken=GomPjYORVYuqBd3DSlJfKDIohheBCof4; _pinterest_sess="TWc9PSZ4dWJoVHRaV3RsVDRmOTJpRzcrVUZZL0lMeXpTbmpYQmRyNkxhV09HV0UvR1ZnUmJsZmt0QVg0MUo2MWJmZ2x4Y2wrRkp1NFlzd2VGUUJRbnJ6ZUcxcWdNek5XQmNPMm9LbnFodVplZEtRNVdIZVBqMG00ZktzckNHS2dkUzBLc0JITzVraXhrL04wVWZjbmN3L1RIL3dwZ3h6QkVFb3BEWHd3TVJpUEY5SmUreGptaUdUdDFuNVNuWVduRUJ3MjZPSnlKcERJRjBWeGVRVmMzTzNtZ0x3Ylh1TDVRcWtCeENMeStaZEJXUHlsTzA0UE9ycnFoMWM1bCtDQUVKRmR3cWtTNSt1OHBFbGxOUE1TRkQzVWx4R0tJcjdnY1Voek1vMzk4blFxbDltYml4S01SYVExSDBzd3Q4TC9BSkZOR1NLejRyMHJBQXhISmxrL1FCd0ttSHhUVERUVEE1SVVKNEJ2SW1kbTdVT09KQWpCMTZNSTZYNVVJcFI3NGNMc3liUVRpMGJqSFV5Uzl2N3NSNUZKdG5UVDlBNkJ6aFdjaGlKYTNQSDZzaUkvUHJXdCtwUDB4bkxtWk5TZm5pdm00WHZydktpM01mS2xlT20wTytzQlpEelZLUVVIdlNMOUJCK2FRMzVsbWFPUT0meUswZzN0R3NMblp2a0oyZkxDZWhZTWdVcVBJPQ=="; cm_sub=none; c_dpr=1; c_vh=947; c_vw=1903; sessionFunnelEventLogged=1; bei=false; _b="ASuRBc5GTIBFc6/tqnUAofH/k9Xq+4bd60WGwiKwDLAd5QWO0SV3asiv82mWwraEvS4="; _pinterest_pfob=disabled',
           'Connection': 'keep-alive',
           'Pragma': 'no-cache',
           'Cache-Control': 'no-cache'}

# cookie = {}
# my_cookie = '_pinterest_cm=TWc9PSZPeGN1eEMvMmorUXI2elA0NHRkVHh0eG5BWTJyMldTWjVlZldGK3lNYko\
# zbXZtTEc0NnZib1FPWW9YYTY3bUVtZGthSkhncGRwb25wZEhNb3FBWG1WcXI5bjJWWmJZSTlvYUtpaHpkTFgy\
# SlludTM2YWZzbTBVRHNuSDNUUU9NNyZzbTdMeFRyK2oyTkIzTWIvaDRVd2JRUkx2b2c9; _b="ASuTQJd/jcJAIoQqN9abU26PD77tQ0osfM2tLfJoZG5K+of8q8BOx8iicdfANEd4Y3Q="; \
# _pinterest_pfob=disabled; sessionFunnelEventLogged=1; unauthHybridCloseupCount=1; _pinterest_referrer="https://github.com/jiangecho/pinterest-crawler"; \
# logged_out=True; fba=True; c_dpr=1; c_vh=950; c_vw=1903; bei=false; cm_sub=denied; _auth=1; csrftoken=lXVJostVunz9URERI3QL0OaTI1ktHvBf; \
# _pinterest_sess="TWc9PSYrM0IyUFM4SDJyejJ2RjlBUHc0cmpKRHlBVnNvVHdCcXNSMnNUYWRvb1NxbjVUTDN2WDZHZGdwLzlpYkx2OVVlQkc1TGU3QkxCSXBmTmNkbVZHVTFIaEZsdVBiVnV5akZU\
# QjRMbmd0emFWNGpjL1JPT3BqT0IvbzQwU2o0QVNBcjN6UnBoaXh4UnFOdDNmWE0zL3N4dytVWEQ2WFZqZFBuQVJjVTN6K0VFdjlYL05lN2kwRzF4YW9IVkluUXZNalZ4aHVuK2J1Q3MwWHkyUlBKcC9oal\
# Axbko2ZWxtNUFZbGVrSEFIeW1Tdi9sNUpHL2tZMTlUZFZpM2pGTkJxaFFHUHU0SDdvKzJVbk0vSy94Z0xMdEt5V3VudWFDKzdSSXlyczEzcHlKcC9PdmV4R0l1NlBQZTlCbG5zVHhuTkx3NkRoS0NoRHk1e\
# lA2NVZvQzVYRHZhdXUzTXV2aWMrVGt6N052cFFDYWhYWkhDUlN5VWFlNW5wbndjQzJJYWNFcnpUTmhuRlh1Rk56MDVmVnhab3BzaUJmamIwdWI5TVplb0M0b1ZwYXpxY2M2QXdzTG1YTXc4cnJOK1dsVzVxT\
# 0tQbEpHdHYxQVBOc3hrL1UrS2t1YW1QdS80aFNkVlhYeHhvRXpRZlUwN1NzVT0mRDQwMjZJZm41dlNnNEZDampvelA0Rk5aSEtzPQ=="'
#  
# for line in my_cookie.split(';'):
#     key,value = line.split("=", 1)
#     cookie[key] = value
#     
# response = requests.get(url, cookies=cookie)
# html = response.text
# dowmload_image(html)

# url_second = 'https://www.pinterest.com/resource/UserHomefeedResource/get/'
# params = {'source_url': '/', 'data': '{"options":{"bookmarks":["Y2JVSG80T1ZFd1JrSlJhMFpDVVZWR1FsRlhPVUpSVjJSQ1VWVkdWMDVGYkVWa2JHUllVVEJHUWxKRlJrSlJWVVpPVlZjNVFsRnJaM1pNZVRoMlRIazRka3d6VW5KUk1FWkNVakJHUWxGVlJsVlZWemxDVVRCbmRreDVPSFpNZVRoMlRETlNjbEZWUlRsUVdIYzFUVlJvYUZwVWFHcE9SRVY2VDBSRk1rMVVSVFZaZWtreVQwUkZOVnBIVm10WmFtZDRUVVJhYlUxNlJUTlphbHByV1dwWk5FMXFXbWxQUkZKcVdsUlpNMDE2VlRST1IwMTVXVEpGZVU1SFdtbFpNbEpxOlVIbzVUMkl5Tld4bVJFNXJUMVJOTUZwVVFUSlBSR3MxVFRKUmVFNHlWVFZhUkVVelQwZE9iRmxVU1RSWlYxcHRUbFJuTlU1NlNYaGFhbHBvVG5wc2JFNUVRWGhhVkVGNVdrZFpNazR5UlRSTmVtaHFXVlJhYTA5WFVYaGFSRms5fDUxZDBiODg5ODU3ODk5MTc3MjM0ZWEyNjA1ZDc4NDViMTUwYmI2YWRkMTEzN2Y2Y2UxYTI0ZmVhMWExMTQ3ODY="],"is_react":true,"static_feed":false,"prependPartner":false,"prependUserNews":false,"field_set_key":"grid_item_with_rec"},"context":{}}', '_': '1503373830122'}
# response_second = requests.get(url_second, headers=headers, params=params)
# print(response_second.status_code)
# print(response_second.json())
if __name__ == '__main__':
    key_world = input("请输入要搜索的关键字，输入后回车！ \n")
    my_dict = {'options':{'query': key_world,'scope':'pins'},'context':{}}
    url = 'https://www.pinterest.com/resource/SearchResource/get/'
    params = {'source_url': '/search/pins/?rs=ac&len=20&q=%E8%A5%BF%E8%97%8F&eq=%E8%A5%BF%E8%97%8F&etslf=1259&term_meta[]=%E8%A5%BF%E8%97%8F%7Cautocomplete|undefined',
          'data': json.dumps(my_dict)}

    response = requests.get(url, headers=headers, params=params)
    json_data = response.json()
    dowmload_image(json_data)







import requests
import json
import urllib

# search = urllib.parse.quote('西藏')
# url = 'http://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&ct=201326592&is=&fp=result&queryWord=%E8%A5%BF%E8%97%8F&cl=2&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=-1&z=&ic=0&word=%E8%A5%BF%E8%97%8F&s=&se=&tab=&width=&height=&face=0&istype=2&qc=&nc=1&fr=&pn=30&rn=30&gsm=1e&1501741642605='
# url = 'http://image.baidu.com/search/avatarjson?tn=resultjsonavatarnew&ie=utf-8&word=' + search + '&cg=girl&pn=' + str(
#                 60) + '&rn=60&itg=0&z=0&fr=&width=&height=&lm=-1&ic=0&s=0&st=-1&gsm=1e0000001e'
# response = requests.get(url, timeout=20)
# 
# print(response)
# print(response.text)
# json_data = json.loads(response.text.encode(response.encoding).decode('utf-8'))
# list_data = json_data['data']
# print(list_data)

# url = 'https://gethover.com/api/v1/activation/batch.json?sn=FFB2USM8G0029&start_time=0&end_time=0'
# headers = {'Authorization': 'zzzkjfmdsdslifkadufpeiropqweirp39q0irp2903ui0r9pwoeujqlfeadlkfjdkfd'}
# response = requests.get(url, headers=headers)
# print(response.text)


new_url = "http://1of3u43i2w.china.test.gethover.com/api/v1/aftersale/sn/list.json"
new_response = requests.get(new_url)
print(new_response.text)
print(type(new_response.text))
    
    
    
    
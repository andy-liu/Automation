import json
# url = 'https://i.pinimg.com/236x/f2/f3/05/f2f30585b4d662c163f2312835039d54.jpg'
# url = url.replace('236x', '564x')
# print(url)
# 
# my_str = 'hello world'
# my_str = my_str.replace('world', 'python')
# print(my_str)
# json_data = json.loads('{"request_identifier":"348312622350","resource_data_cache":[{"data":{"is_collaborative":false,"layout":"default","description":"","cover_images":{"400x300":{"url":"https://s-media-cache-ak0.pinimg.com/400x300/80/ee/79/80ee79c66c65dba86100e335c4b6ff32.jpg","width":400,"height":300},"216x146":{"url":"https://s-media-cache-ak0.pinimg.com/216x146/80/ee/79/80ee79c66c65dba86100e335c4b6ff32.jpg","width":216,"height":146}},"privacy":"public","url":"/ljiljanaanavido/tibet/","pin_count":1265,"pin_thumbnail_urls":["https://s-media-cache-ak0.pinimg.com/150x150/ac/da/15/acda152ce09e7ffeb9bdc4cb246f0846.jpg","https://s-media-cache-ak0.pinimg.com/150x150/9c/15/56/9c15564c6ebd2c1aabf54c99d1251f5e.jpg","https://s-media-cache-ak0.pinimg.com/150x150/c2/59/d8/c259d80c5b9b52f5374a336218593b64.jpg","https://s-media-cache-ak0.pinimg.com/150x150/d7/71/d7/d771d7c4bd4dd20116ad128e4ec634f5.jpg","https://s-media-cache-ak0.pinimg.com/150x150/ce/a1/76/cea1762687b32fdeff1c105a4ed79c27.jpg"],"image_thumbnail_url":"https://s-media-cache-ak0.pinimg.com/upload/504966245658388957_board_thumbnail_2017-08-09-21-19-03_63041_60.jpg","access":[],"collaborated_by_me":false,"owner":{"username":"ljiljanaanavido","domain_verified":false,"is_default_image":true,"image_medium_url":"https://s.pinimg.com/images/user/default_75.png","explicitly_followed_by_me":false,"full_name":"ljiljana vidovic","verified_identity":{},"type":"user","id":"504966314377377584"},"followed_by_me":false,"type":"board","id":"504966245658388957","name":"tibet"},"resource":{"name":"BoardResource","options":{"board_id":"504966245658388957","shadow_request_data":{},"shadow_request_path":"/v3/boards/504966245658388957/","field_set_key":"grid_item","bookmarks":["-end-"],"shadow_post_request":true,"shadow_request_headers":{"X-Pinterest-Csrf":"lXVJostVunz9URERI3QL0OaTI1ktHvBf","X-Prefer-User-Locale":"1","X-Pinterest-Root-Rid":"348312622350","Accept-Language":"en-US","X-Pinterest-Parent-Rid":"348312622350","X-Bot":"false","X-Pinterest-Browser-Extension-Installed":"false","User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36","X-Pinterest-Rid":"348312622350","X-Pinterest-App-Type":5,"X-Pinterest-AppState":"background","X-Pixel-Ratio":1.0,"X-Referrer":"https://www.pinterest.com/","X-Pinterest-Referrer":"https://github.com/jiangecho/pinterest-crawler","X-Real-Ip":"45.255.124.44","Cookie":"_b=ASuTQJd/jcJAIoQqN9abU26PD77tQ0osfM2tLfJoZG5K+of8q8BOx8iicdfANEd4Y3Q=;cm_sub=none","X-Pinterest-InstallId":"dadf129c54a441fc9d155e5ea80bf15f","X-Url":"https://www.pinterest.com/?module_path=%5B%27App%28module%3D%5Bobject+Object%5D%29%27%5D&data=%5B%27%7B%22options%22%3A%7B%22board_id%22%3A%22504966245658388957%22%2C%22field_set_key%22%3A%22grid_item%22%7D%2C%22context%22%3A%7B%7D%2C%22module%22%3A%7B%7D%7D%27%5D&_=%5B%271502879639240%27%5D&source_url=%5B%27%2F%27%5D","X-Pinterest-Real-Ip":"45.255.124.44"}}}}],"resource":{"name":"BoardResource","options":{"board_id":"504966245658388957","shadow_request_data":{},"shadow_request_path":"/v3/boards/504966245658388957/","field_set_key":"grid_item","bookmarks":["-end-"],"shadow_post_request":true,"shadow_request_headers":{"X-Pinterest-Csrf":"lXVJostVunz9URERI3QL0OaTI1ktHvBf","X-Prefer-User-Locale":"1","X-Pinterest-Root-Rid":"348312622350","Accept-Language":"en-US","X-Pinterest-Parent-Rid":"348312622350","X-Bot":"false","X-Pinterest-Browser-Extension-Installed":"false","User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36","X-Pinterest-Rid":"348312622350","X-Pinterest-App-Type":5,"X-Pinterest-AppState":"background","X-Pixel-Ratio":1.0,"X-Referrer":"https://www.pinterest.com/","X-Pinterest-Referrer":"https://github.com/jiangecho/pinterest-crawler","X-Real-Ip":"45.255.124.44","Cookie":"_b=ASuTQJd/jcJAIoQqN9abU26PD77tQ0osfM2tLfJoZG5K+of8q8BOx8iicdfANEd4Y3Q=;cm_sub=none","X-Pinterest-InstallId":"dadf129c54a441fc9d155e5ea80bf15f","X-Url":"https://www.pinterest.com/?module_path=%5B%27App%28module%3D%5Bobject+Object%5D%29%27%5D&data=%5B%27%7B%22options%22%3A%7B%22board_id%22%3A%22504966245658388957%22%2C%22field_set_key%22%3A%22grid_item%22%7D%2C%22context%22%3A%7B%7D%2C%22module%22%3A%7B%7D%7D%27%5D&_=%5B%271502879639240%27%5D&source_url=%5B%27%2F%27%5D","X-Pinterest-Real-Ip":"45.255.124.44"}}},"client_context":{"origin":"https://www.pinterest.com","unauth_id":"dadf129c54a441fc9d155e5ea80bf15f","is_retina":false,"nag_browser_unsupported":false,"locale":"en-US","utm_campaign":null,"is_managed_advertiser":false,"browser_version":"60.0.3112","root_request_identifier":null,"parent_request_identifier":null,"deep_link_action":null,"path":"/resource/BoardResource/get/","user_agent_platform":"other","visible_url":"/","react_only":null,"is_tablet_agent":false,"seo_experiments":{},"is_full_page":false,"browser_type":1,"deep_link":"","site_type":0,"is_mobile_agent":false,"is_bot":"false","user_agent_platform_version":null,"invite_code":null,"request_host":"www.pinterest.com","is_authenticated":true,"in_mobile_fork_exp":false,"utm_medium":null,"placed_experiences":null,"is_open_experience":false,"app_version":"98b9726","analysis_ua":{"os_name":"Windows 10","app_type":5,"browser_name":"Chrome","os_version":"","browser_version":"60.0.3112","device_type":null,"device":"Other"},"site_const":{"PIN_MARGIN":14,"MAX_COLUMNS":10,"MIN_COLUMNS":3,"PRESENTER_BUTTON_MODULE_NAME":"DropdownButton","PIN_WIDTH":236},"request_identifier":"348312622350","app_shell":false,"real_ip":"45.255.124.44","active_experiments":{"web_pure_react5":"control"},"current_url":"https://www.pinterest.com/resource/BoardResource/get/?source_url=%2F&data=%7B%22options%22%3A%7B%22board_id%22%3A%22504966245658388957%22%2C%22field_set_key%22%3A%22grid_item%22%7D%2C%22context%22%3A%7B%7D%2C%22module%22%3A%7B%7D%7D&module_path=App(module%3D%5Bobject+Object%5D)&_=1502879639240","has_ads_api_access":false,"user":{"is_employee":false,"phone_number":null,"phone_number_end":"","last_name":"","domain_verified":false,"nags":[],"image_medium_url":"https://s.pinimg.com/images/user/default_75.png","has_password":true,"image_xlarge_url":"https://s.pinimg.com/images/user/default_280.png","full_name":"AndyLau","unverified_phone_number_without_country":"","image_small_url":"https://s.pinimg.com/images/user/default_30.png","gplus_url":null,"id":"700802529423833999","is_write_banned":false,"first_name":"AndyLau","domain_url":null,"facebook_timeline_enabled":false,"facebook_id":"","connected_to_google":false,"is_partner":false,"unverified_phone_number":null,"type":"user","email":"liuguoping@zerozero.cn","image_large_url":"https://s.pinimg.com/images/user/default_140.png","connected_to_yahoo":false,"phone_country":null,"verified_identity":{},"twitter_url":null,"facebook_url":null,"unverified_phone_country":null,"has_mfa_enabled":false,"twitter_publish_enabled":false,"resurrection_info":null,"facebook_publish_stream_enabled":false,"connected_to_microsoft":false,"gender":"male","created_at":"Thu, 10 Aug 2017 10:50:42 +0000","verified_domains":[],"can_enable_mfa":false,"username":"liuguoping","login_state":1,"website_url":null,"country":"CN"},"deep_link_default":"","http_referrer":"https://www.pinterest.com/","app_type":5,"from_open_in_app_click":null,"is_amp":false,"is_internal_ip":false,"csp_nonce":"gfTRijzimv","language":"en","sterling_on_steroids_ldap":null,"is_sterling_on_steroids":false,"facebook_token":null,"user_agent_can_use_native_app":false,"is_eligible_for_one_tap_sterling":false,"browser_name":"Chrome","browser_locale":null,"user_agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36","user_agent_is_ios_9_or_above":false,"referrer":"https://github.com/jiangecho/pinterest-crawler","error_template_path":"templates/error.nunjucks","country":"CN","full_path":"/resource/BoardResource/get/?source_url=%2F&data=%7B%22options%22%3A%7B%22board_id%22%3A%22504966245658388957%22%2C%22field_set_key%22%3A%22grid_item%22%7D%2C%22context%22%3A%7B%7D%2C%22module%22%3A%7B%7D%7D&module_path=App(module%3D%5Bobject+Object%5D)&_=1502879639240"},"resource_response":{"data":{"is_collaborative":false,"layout":"default","description":"","cover_images":{"400x300":{"url":"https://s-media-cache-ak0.pinimg.com/400x300/80/ee/79/80ee79c66c65dba86100e335c4b6ff32.jpg","width":400,"height":300},"216x146":{"url":"https://s-media-cache-ak0.pinimg.com/216x146/80/ee/79/80ee79c66c65dba86100e335c4b6ff32.jpg","width":216,"height":146}},"privacy":"public","url":"/ljiljanaanavido/tibet/","pin_count":1265,"pin_thumbnail_urls":["https://s-media-cache-ak0.pinimg.com/150x150/ac/da/15/acda152ce09e7ffeb9bdc4cb246f0846.jpg","https://s-media-cache-ak0.pinimg.com/150x150/9c/15/56/9c15564c6ebd2c1aabf54c99d1251f5e.jpg","https://s-media-cache-ak0.pinimg.com/150x150/c2/59/d8/c259d80c5b9b52f5374a336218593b64.jpg","https://s-media-cache-ak0.pinimg.com/150x150/d7/71/d7/d771d7c4bd4dd20116ad128e4ec634f5.jpg","https://s-media-cache-ak0.pinimg.com/150x150/ce/a1/76/cea1762687b32fdeff1c105a4ed79c27.jpg"],"image_thumbnail_url":"https://s-media-cache-ak0.pinimg.com/upload/504966245658388957_board_thumbnail_2017-08-09-21-19-03_63041_60.jpg","access":[],"collaborated_by_me":false,"owner":{"username":"ljiljanaanavido","domain_verified":false,"is_default_image":true,"image_medium_url":"https://s.pinimg.com/images/user/default_75.png","explicitly_followed_by_me":false,"full_name":"ljiljana vidovic","verified_identity":{},"type":"user","id":"504966314377377584"},"followed_by_me":false,"type":"board","id":"504966245658388957","name":"tibet"},"error":null}}')
# dict = json_data['resource_data_cache'][0]
# print(len(dict['data']['pin_thumbnail_urls']))
# for key in dict:
#     print(key + ': '+ str(dict[key]))

a = ["a1", "a2", "a3"]
# print(a[:2])

# a[:3] = "test"
# print(a)

class test():
    a = 3
    b = list(a+i for i in range(10))
 
my_test = test()
print(my_test.b)






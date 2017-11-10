#-*- coding:utf-8 -*-
import os

def dirlist(path, all_file_list):
    first_level_file_list = os.listdir(path)
#     print(first_level_file_list)
    for file_name in first_level_file_list:
        file_path = os.path.join(path, file_name)
        if (os.path.isdir(file_path)):
            dirlist(file_path, all_file_list)
        else:
            all_file_list.append(file_path)
    return all_file_list

if __name__ == '__main__':
    path = 'D:\\spider_result\\test_text'
#     print(dirlist(path, []))
#     for dir_path in os.walk(path):
#         print(dir_path)
    for i in range(50):
        file_path = 'D:\\spider_result\\test_text\\' + str(i) + '.txt'
        with open(file_path, 'w') as fp:
            fp.write('qqqqqqqqqqqqqqaaaqqqqqqqqqaaaqqqqqqqqq\nwwwwwwwwaaawwwwwwwwwaaawwwwwwwwww\neeeeeeeeee\nrrrrrrrrr\ntttttttt')
    
    for each in dirlist(path, []):
        with open(each, 'r+') as fp:
            my_str = fp.read()
            new_str = my_str.replace('aaa', 'bbb')
            fp.seek(0, 0)
            fp.write(new_str)



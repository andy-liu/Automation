# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class LagoujobItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    position_name = scrapy.Field()
    position_salary = scrapy.Field()
    position_company = scrapy.Field()
    position_industry = scrapy.Field()
    position_advantage = scrapy.Field()
    position_address = scrapy.Field()

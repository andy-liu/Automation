# -*- coding: utf-8 -*-
import scrapy
from lagoujob.items import LagoujobItem

class PositionSpider(scrapy.Spider):
    name = 'position'
#     allowed_domains = ['https://www.lagou.com/zhaopin/']
    start_urls = ['https://www.lagou.com/zhaopin//']

    def parse(self, response):
        item = LagoujobItem()
        selector = scrapy.Selector(response)
#         print(selector.xpath('//li[@class="con_list_item default_list"]/@data-positionname').extract())
#         print(selector.xpath('//li[@class="con_list_item default_list"]/@data-company').extract())
#         print(selector.xpath('//li[@class="con_list_item default_list"]/@data-salary').extract())
        positions = selector.xpath('//li[@class="con_list_item default_list"]')
        for position in positions:
            name = position.xpath('div[@class="list_item_top"]/div[@class="position"]/div[@class="p_top"]/a/h3/text()')\
            .extract()[0]
            company = position.xpath('div[@class="list_item_top"]/div[@class="company"]/div[@class="company_name"]/a/text()').extract()[0]
            salary = position.xpath('div[@class="list_item_top"]/div[@class="position"]/div[@class="p_bot"]/div[@class="li_b_l"]/span/text()')\
            .extract()[0]
            industry = position.xpath('div[@class="list_item_top"]/div[@class="company"]/div[@class="industry"]/text()').extract()[0]
            advantage = position.xpath('div[@class="list_item_bot"]/div[@class="li_b_r"]/text()').extract()[0]
            industry = industry.replace(' ','').replace('\n','')
            address = position.xpath('div[@class="list_item_top"]/div[@class="position"]/div[@class="p_top"]/a/span/em/text()')\
            .extract()[0]
            
            item['position_name'] = name
            item['position_salary'] = salary
            item['position_company'] = company
            item['position_industry'] = industry
            item['position_advantage'] = advantage
            item['position_address'] = address
            yield item
            
        all_urls = selector.xpath('//a/@href').extract()
#         print(len(all_urls))
        for url in all_urls:
            if url.startswith('https://www.lagou.com/zhaopin/'):
                print(url)
                yield scrapy.http.Request(url, callback=self.parse)
            
            
            

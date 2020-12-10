package com.earbuds.pricecomparisonscraper.service;

import com.earbuds.pricecomparisonscraper.model.AmazonData;
import com.earbuds.pricecomparisonscraper.repository.AmazonRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AmazonService {


    @Autowired
    AmazonRepository amazonRepository;

    public void AmazonLoadData() {
        try {
            Document doc = Jsoup.connect("https://www.amazon.com/Earbud-In-Ear-Headphones/b?ie=UTF8&node=12097478011").get();
            Elements EarBudTitles = doc.select("h2 > a.a-text-normal");
            Elements EarBudAmounts = doc.select("span.a-offscreen");

            System.out.println(EarBudAmounts.text()+"\n");

            List<AmazonData> AmzDataList = new ArrayList<>();
            int id = 1;
            for(Element EarBudTitle:EarBudTitles) {
                AmazonData AmzData = new AmazonData();
                for(Element EarBudAmount:EarBudAmounts) {
                    //AmzData.setId(id);
                    //AmzData.setProductTitle(EarBudTitle.text());
                    //AmzData.setProductPrice(EarBudAmount.text());
                    //AmzDataList.add(AmzData);
                    System.out.println(EarBudAmount.text()+"\n");
                }
                id = id + 1;
            }
            amazonRepository.saveAll(AmzDataList);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}

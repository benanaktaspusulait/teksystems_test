package com.teksystems;

import com.teksystems.domain.dto.CalculateDTO;
import com.teksystems.domain.models.good.base.Good;
import com.teksystems.service.CalculateService;

import javax.script.ScriptException;
import java.util.*;

public class CalculateApplication {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {

        Scanner scanner = new Scanner(System.in);
        String goodText = scanner.nextLine();

        calculate(goodText);
    }

    public static void calculate(String goodText) throws ScriptException, NoSuchMethodException {
        String[] goodArray = goodText.split(" ");

        List<Good> goodList = new ArrayList<>();
        List<String> goodListText = Arrays.asList(goodArray);

        Integer day = Integer.valueOf(goodListText.get(goodListText.size() - 1));

        goodListText.subList(0, goodListText.size() - 1).stream().forEach(g -> goodList.add(CalculateDTO.convertStringToGood(g)));

        String text = CalculateService.calculate(CalculateDTO.generateDTO(goodList), goodList, Integer.valueOf(day));

        System.out.print(text);
    }


}

package ru.job4j.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class UserConvertTest {
    @Test
    public void convertListToMap() {
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> map = userConvert.process(Arrays.asList(new User(0, "Андрей", "Томск"),
                new User(1, "Иван", "Москва"), new User(2, "Вася", "Санкт-Петербург")));
        for (Integer key : map.keySet()) {
            System.out.println(String.format("Id:%d, Имя:%s, город:%s", key, map.get(key).getName(), map.get(key).getCity()));
        }
    }
}

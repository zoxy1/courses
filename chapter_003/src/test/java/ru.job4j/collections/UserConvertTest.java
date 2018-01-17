package ru.job4j.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void convertListToMap() {
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> map = userConvert.process(Arrays.asList(new User(0, "Андрей", "Томск"),
                new User(1, "Иван", "Москва"), new User(2, "Вася", "Санкт-Петербург")));
        for (Integer key : map.keySet()) {
            System.out.println(String.format("Id:%d, Имя:%s, город:%s", key, map.get(key).getName(), map.get(key).getCity()));
        }
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(0, new User(0, "Андрей", "Томск"));
        expected.put(1, new User(1, "Иван", "Москва"));
        expected.put(2, new User(2, "Вася", "Санкт-Петербург"));
        assertThat(map, is(expected));
    }
}

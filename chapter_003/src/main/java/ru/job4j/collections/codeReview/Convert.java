package ru.job4j.collections.codeReview;
// лишнии пробелы перед импортом
        import java.util.*;

public class Convert {

    // конструктор без входных параметров можно не указывать(вызовется по умолчанию)
    public Convert(){ //не хватает пробела после круглых скобок

    }

    /* комментарии к методу лучше вообще не использовать если по коду понятно что он делает или лучше правильно выбирать
     * название метода, чтобы сразу было понятно для чего он нужен или использова JavaDoc
     * нет модификатора доступа, вне пакет данный метод будет не доступен, лучше указать public,
     * тоже самое для метода makeArray
     */
    //Converts array to list
    List<Integer> makeList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>(); // обычно стараются везде использовать интерфейсы для того чтобы
        // вслучае необходимости можно было например без переписывания основного кода ArrayList заменить на LinkedList
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                list.add(array[i][j]);
        }
        return list;
    }

    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);
        /* много пустых строк, пустые строки (обычно одну, две) добавляют для лучшей читабельности и если нужно выделить
         * какой то блок кода
         */


        int[][] array = new int[rws][cls]; // после объявления переменных ставится пустая строка 
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext()) // принято добавлять фигурные скобки даже если используется один оператор
                    array[i][j] = iterator.next();
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
}

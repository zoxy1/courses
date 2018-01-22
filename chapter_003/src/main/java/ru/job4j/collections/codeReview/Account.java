package ru.job4j.collections.codeReview;

public class Account {
    // согласно принципу ООП нужно указать модификатор доступа private
    double values;
    String reqs;

    public Account(double values, String requisites) { // переменную values лучше назвать value значение же одно,
        // values больше подойдет для названия массивов, коллекций
        // неправильное написание имени переменной, заменить на requestSites
        // В языке Java принято использовать lowerCamelCase — для именования экземпляров классов и методов,
        // не final переменных.
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }


    public String getReqs () {
        return this.reqs;
    }
// если метод будет использоваться не только в этом же пакете, то нужно добавить модификатор доступа public
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    public String toString() { // тело метода можно заменить на
        // return "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        String otvet;
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        return otvet;
    }
    // обычно ставят аннотацию, что метод переопределяется @Override
    // думаю нужно еще добавить переменную values для сравнение аккаунтов(в зависимости от логики)
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs);
    }
    // обычно ставят аннотацию, что метод переопределяется @Override
    // думаю нужно еще добавить переменную values, если она будет добавлена в equals
    public int hashCode() {
        return this.reqs.hashCode();
    }
}

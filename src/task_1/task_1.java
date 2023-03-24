package task_1;

//Создать класс Сотрудник (Employee) с полями:
//        Имя, Фамилия (String)
//        Название отдела (String)
//        Зарплата (double)
//        Реализовать equals и hashCode, который работает только с именем и фамилией
public class task_1 {
    public static void main(String[] args) {
        new Employee().hashCode();
        new Employee().equals(new Object());
    }
}

class Employee{
    String name;
    String surname;
    String nameDepartment;
    double salary;
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)return true;
        if (obj==null)return  false;
        if (getClass()!=obj.getClass())return false;

        final Employee employee=(Employee) obj;
        if (employee.name==null || employee.surname==null)return false;
        if (this.name.equals(employee.name) && this.surname.equals(employee.surname))return true;
        return false;
    }
    @Override
    public int hashCode(){
        int nullChecker=(this.name==null || this.surname==null)?0:1;
        return 31*nullChecker*this.name.hashCode()*this.surname.hashCode();
    }
}
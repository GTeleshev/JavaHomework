package Seminar2;

public class Problem1 {
//    1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
//    используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
//    Если значение null, то параметр не должен попадать в запрос.
//    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//    Результат "select * from students where “name” = “Ivanov” and “country”=”Russia” …

    public static void main(String[] args) {
        String JsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println("Исходная строка Json: " + JsonString);
        String[] arr = SplitJsonString(JsonString);
        String[][] newStr = SplitInto2DArray(arr);
        System.out.println("Выходная строка SQL: " + SQLString(newStr, "SELECT * FROM STUDENTS WHERE ", "null"));
    }
    public static String[] SplitJsonString(String JsonString){
        String newString = JsonString.replace("\"","").
                replace("{","").replace("}","").replace(" ","");
        String[] str = newString.split(",");
        return str;
    }
    public static String[][] SplitInto2DArray(String[] str){
        String[][] outArray = new String[str.length][2];
        for (int i = 0; i < str.length; i++) {
            String[] tmp = str[i].split(":");
            outArray[i][0] = tmp[0];
            outArray[i][1] = tmp[1];
        }
        return outArray;
    }
    public static void Print2DArray(String[][] inpArray){
        for (int i = 0; i < inpArray.length; i++) {
            for (int j = 0; j < inpArray[i].length; j++) {
                System.out.print(inpArray[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static String SQLString(String[][] StrArray, String StrPrefix, String StrIgnore){
        StringBuilder SQLStr;
        SQLStr = new StringBuilder(StrPrefix);
        for (String[] strings : StrArray) {
            if (!strings[1].equals(StrIgnore)) {
                String StrToAppend = "\"" + strings[0] + "\"=\"" + strings[1] + "\" and ";
                SQLStr.append(StrToAppend);
            }
        }
        SQLStr = new StringBuilder(SQLStr.substring(0, SQLStr.length() - 5));
        return SQLStr.toString();
    }
}

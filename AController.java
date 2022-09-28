package Buoi9;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AController {
    public static void main(String[] args) {

        List<AthenaStudent> students = new ArrayList<>();
        Boolean paid;
        if(paid = true) {
            System.out.println("da nop");
        }
        else if (paid = false){
            System.out.println("chua nop");
        }
        students.add(new AthenaStudent("1","nam","0987512251","JSP", LocalDate.parse("2001-12-14"), List.of(7, 8, 9, 6, 6),true));
        students.add(new AthenaStudent("1","nam","","JB", LocalDate.parse("2001-12-14"), List.of(7, 8, 9, 6, 6,7),true));
        students.add(new AthenaStudent("12","nam","0987512251","JSB", LocalDate.parse("2001-12-14"), List.of(7, 8, 9, 6, 6),false));
        students.add(new AthenaStudent("123","cong","0987512251","JSP", LocalDate.parse("2001-12-14"), List.of(7, 8, 9, 6, 6),true));
        students.add(new AthenaStudent("1234","duc","0987512251","JSP", LocalDate.parse("2001-12-14"), List.of(7, 8, 9, 0, 6,9),false));
        students.add(new AthenaStudent("12345","quan","","JSP", LocalDate.parse("2001-12-14"), List.of(7, 8, 9, 6, 6,8),true));
        students.add(new AthenaStudent("123456","tan","0987512251","JSP", LocalDate.parse("2001-12-14"), List.of(9, 8, 9, 10),false));
        students.add(new AthenaStudent("1234567","nghia","0987512251","JSP", LocalDate.parse("2001-12-14"), List.of(7, 8, 9, 6, 6),false));
        System.out.println(students);
        System.out.println("");

        Map<String, List<AthenaStudent>> map = new HashMap<>();
        students.forEach(student -> {
            List<AthenaStudent> nClass = map.get(student.getNameClass());
            if (nClass == null) {
                nClass = new ArrayList<>() {
                    {
                        add(student);
                    }
                };
            } else {
                nClass.add(student);
            }
            map.put(student.getNameClass(), nClass);
        });
        System.out.println("JB :" + map.get("JB"));
        System.out.println("JSB :" + map.get("JSB"));
        System.out.println("RJ :" + map.get("RJ"));
        System.out.println("JSP :" + map.get("JSP"));
        System.out.println("AD :" + map.get("AD"));
        System.out.println("RN :" + map.get("RN"));

        AController aController = new AController();
//        System.out.println("Danh sach :");
//        System.out.println(aController.deviceStudentToClass(students));
        System.out.println("-----------------------");
        System.out.println("Danh sach sau khi limit:");
        System.out.println(aController.limitStudentToClass(students));
        System.out.println("-----------------------");
        System.out.println("Danh sach hv chua nop tien:");
        System.out.println(aController.noPaidStudentToClass(students));
        System.out.println("-----------------------");
        System.out.println("Danh sach hv chua dien sdt:");
        System.out.println(aController.noSdtStudentToClass(students));
//        System.out.println("-----------------------");
//        System.out.println("Danh sach hv co thanh tich xuat sac la:");
//        System.out.println(aController.excellentAchievementStudentToClass(students));
        System.out.println("-----------------------");
        System.out.println("Danh sach hv co diem cao nhat la:");
        System.out.println(aController.scoreMaxStudentToClass(students));
        System.out.println("-----------------------");
        System.out.println("Danh sach hv hoc 2 khoa tro len");
        System.out.println(aController.nameStudentToClass(students));
        System.out.println("-----------------------");

    }

    public Map<String, List<AthenaStudent>> deviceStudentToClass(List<AthenaStudent> students) {
        return students.stream()
                .collect(Collectors.groupingBy(AthenaStudent::getNameClass,
                        HashMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
    }
    public Map<String, List<AthenaStudent>> limitStudentToClass(List<AthenaStudent> students) {
        var athena = students.stream()
                .collect(Collectors.groupingBy(AthenaStudent::getNameClass,
                        HashMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
        Map<String, List<AthenaStudent>> newClass = new HashMap<>();
        athena.forEach((nameClasss, studentInClass) -> { newClass.put(nameClasss, studentInClass.stream()
                .limit(2).collect(Collectors.toList()));});
        return newClass;
    }
    public HashMap<String, List<AthenaStudent>> noPaidStudentToClass(List<AthenaStudent> students) {
        var athena1 = students.stream()
                .collect(Collectors.groupingBy(AthenaStudent::getNameClass,
                        HashMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
        Map<String, List<AthenaStudent>> newClass1 = new HashMap<>();
        athena1.forEach((paid, studentInClass) -> { newClass1.put(paid, studentInClass.stream()
                .filter(student -> student.getPaid().equals(false)).collect(Collectors.toList()));});
        return (HashMap<String, List<AthenaStudent>>) newClass1;
    }
    public HashMap<String, List<AthenaStudent>> noSdtStudentToClass(List<AthenaStudent> students) {
        var athena2 = students.stream()
                .collect(Collectors.groupingBy(AthenaStudent::getNumberPhone,
                        HashMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
        Map<String, List<AthenaStudent>> newClass2 = new HashMap<>();
        athena2.forEach((sdt, studentInClass) -> { newClass2.put(sdt, studentInClass.stream()
                .filter(student -> student.getNumberPhone().length() == 0).collect(Collectors.toList()));});
        return (HashMap<String, List<AthenaStudent>>) newClass2;
    }
//    public Map<String, List<String>> excellentAchievementStudentToClass(List<AthenaStudent> students) {
//
//    }
    public HashMap<String, List<AthenaStudent>> scoreMaxStudentToClass(List<AthenaStudent> students) {
        List<AthenaStudent> listStudentMaxScore = new ArrayList<>();
        students.forEach(student -> {
            List<Integer> scores= student.getScore();
            int count = 0;
            for (Integer score : scores){
                if (score < 8){
                    break;
                }else {
                    count++;
                }
            }
            if (count > 0) {
                listStudentMaxScore.add(student);
            }
        });
        return (HashMap<String, List<AthenaStudent>>) deviceStudentToClass(listStudentMaxScore);
    }

    public Map<String, List<AthenaStudent>> nameStudentToClass(List<AthenaStudent> students) {
        var athena5 = students.stream()
                .collect(Collectors.groupingBy(AthenaStudent::getName,
                        HashMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
        Map<String, List<AthenaStudent>> newClass5 = new HashMap<>();
        athena5.forEach((name, studentInClass) -> { newClass5.put(name, studentInClass.stream()
                .filter(student -> student.getName().equals("nam") && (long) student.getNameClass().length() >= 2).toList());
        });
        return newClass5;
    }
}

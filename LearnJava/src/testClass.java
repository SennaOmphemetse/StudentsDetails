import java.util.Scanner;

public class testClass {
    public static void main(String [] args)
    {
        School [] arrSchool = new School[10];
        arrSchool = FillArray(arrSchool);
        DisplayArray(arrSchool);
        Delete(arrSchool);
        DisplayArray(arrSchool);
        UpdateList(arrSchool);


    }

    public static School [] FillArray(School [] MyArray)
    {
        Scanner name = new Scanner(System.in);
        Scanner number = new Scanner(System.in);
        Scanner mark = new Scanner(System.in);
        Scanner exam = new Scanner(System.in);
        int count = 0;

        System.out.print("Enter yr Name (X to quit): ");
        String stName = name.nextLine();

        while (!(stName.equalsIgnoreCase("X")))
        {

            System.out.print("Enter yr Student Number: ");
            String stNum = number.nextLine();

            System.out.print("Enter yr Participation Number: ");
            int tPma = mark.nextInt();

            System.out.print("Enter yr Exam Number: ");
            int stExam = exam.nextInt();

            MyArray[count] = new School(stName,stNum,tPma,stExam);
            count++;

            System.out.print("\nEnter yr Name (X to quit): ");
            stName = name.nextLine();

        }

        return  MyArray;
    }

    public static void DisplayArray(School [] arrMy)
    {
        System.out.println("\nList of students");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n","   Student Name","   Student number", "   Part mark","   Exam mark", "   Module Mark","   Results");
        for (int k = 0; k < School.getStudentObjCount();k++)
        {
            System.out.printf( String.format("%-3s%s\n",(k+1),arrMy[k].toString()));
        }
    }

    public static School [] Delete(School [] arrLIst)
    {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.print("\nWant to delete (Y or N): ");
        char del = input2.next().charAt(0);

        while (del != 'N')
        {
            System.out.print("\nEnter number to delete: ");
            int num = input.nextInt();

            for( int i = num - 1; i < School.getStudentObjCount() - 1;i++)
            {
                arrLIst[i] = arrLIst[i+1];
            }

            School.setStudentObjCount(School.getStudentObjCount() - 1);

            System.out.printf("\nWant to delete (Y or N): ");
            del = input2.next().charAt(0);
        }

        return arrLIst;
    }

    public static School[] UpdateList(School [] arrUpd)
    {
        Scanner input2 = new Scanner(System.in);
        Scanner choosetoup = new Scanner(System.in);
        Scanner repla = new Scanner(System.in);

        System.out.print("\nWant to Update (Y or N): ");
        char upd = input2.next().charAt(0);

        while (upd != 'N')
        {
            System.out.print("\nWhich to Update Pmark(P) or Exam(E) press C to cancel): ");
            char updd = input2.next().charAt(0);

            while(updd != 'C')
            {
                if(updd=='P')
                {
                    System.out.print("\nEnter number to update: ");
                    int num1 = choosetoup.nextInt();

                    System.out.print("\nEnter number to replace Pmark: ");
                    int newpmark = repla.nextInt();

                    arrUpd[num1 - 1].setPartMark(newpmark);

                    DisplayArray(arrUpd);


                } else if (updd=='E')
                {
                    System.out.print("\nEnter number to update: ");
                    int num1 = choosetoup.nextInt();

                    System.out.print("\nEnter number to replace Exam mark: ");
                    int newExam = repla.nextInt();

                    arrUpd[num1 - 1].setExamMark(newExam);

                    DisplayArray(arrUpd);

                }
                System.out.print("\nWhich to Update Pmark(P) or Exam(E) press C to cancel): ");
                updd = input2.next().charAt(0);
            }

            System.out.print("\nWant to Update (Y or N): ");
            upd = input2.next().charAt(0);
        }
        return arrUpd;
    }
}

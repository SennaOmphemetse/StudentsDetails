public class School {
    private String stName;
    private  String stNumber;
    private int partMark;
    private int examMark;
    private static int studentObjCount = 0;

    public School()
    {
        studentObjCount++;
    }
    public School(String stName, String stNumber, int partMark, int examMark)
    {
        this.stName = stName;
        this.stNumber = stNumber;
        this.partMark = partMark;
        this.examMark = examMark;
        studentObjCount++;
    }

    public String getStName()
    {
        return stName;
    }
    public String getStNumber()
    {
        return stNumber;
    }

    public int getExamMark()
    {
        return examMark;
    }

    public int getPartMark()
    {
        return partMark;
    }

    public void setPartMark(int newPmark)
    {
        partMark = partMark * 0;
        partMark = newPmark;
    }

    public void setExamMark(int newExam)
    {
        examMark = examMark * 0;
        examMark = newExam;
    }

    public int moduleMark()
    {
        int module = 0;
        module = Math.round(((examMark + partMark)/2));
        return module;
    }

    public static void setStudentObjCount(int studentObjCount) {
        School.studentObjCount = studentObjCount;
    }

    public String results(int mark)
    {
        int marks = mark;
        String result;

        if(mark < 50 && getPartMark() >= 40)
        {
            result = "Failed";
        }
        else if((marks >= 50 && marks < 75) && getPartMark() >= 40)
        {
            result = "Pass";
        }
        else if(getPartMark() < 40)
        {
            result = "Fail. sub min";
        }
        else if(marks >= 75 && getPartMark() >= 40)
        {
            result = "Pass, with Dist.";
        }
        else {
            result = "";
        }
        return result;
    }

    public static int getStudentObjCount()
    {
        return studentObjCount;
    }

    @Override
    public String toString()
    {
        String str = String.format("%-20s%-20s%-20d%-20d%-20d%-20s",stName,stNumber,partMark,examMark,moduleMark(),results(examMark));
        return str;
    }
}

package com.harbour.selfwrittendi;

public class ClassRoom {
    @InjectByType
    private ITeacher teacher;
    @InjectByType
    private ITeacherAssistant teacherAssistant;


    public void conductClass() {
        System.out.println("Class is starting");
        teacherAssistant.turnOnProjector();
        teacher.teach();
        teacherAssistant.turnOffProjector();
    }

    public void setTeacher(IgorTeacher teacher) {
        this.teacher = teacher;
    }
}

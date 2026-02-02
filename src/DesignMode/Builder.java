package DesignMode;

import javax.swing.*;
import java.awt.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Builder {
    public static void main(String[] args) {
        Student student = new Student("Tom", 12, "Female"); // 不够优雅
        System.out.println("STU1: " + student);
        Student student2 = new Student.StudentBuilder()
                .name("Jack")
                .age(13)
                .gender("Male").build();
        System.out.println("STU2: " + student2);

    }

    public static class Student {
        private final String name;
        private final int age;
        private final String gender;

        public Student(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public static StudentBuilder builder(String name, int age, String gender) {
            return new StudentBuilder();
        }

        public static class StudentBuilder {
            private String name;
            private int age;
            private String gender;

            // 支持链式调用，需要返回 this 指针
            public StudentBuilder name(String name) {
                this.name = name;
                return this;
            }

            public StudentBuilder age(int age) {
                this.age = age;
                return this;
            }

            public StudentBuilder gender(String gender) {
                this.gender = gender;
                return this;
            }

            public Student build() {
                return new Student(name, age, gender);
            }
        }

        @Override
        public String toString() {
            return name + " " + age + " " + gender;
        }
    }
}

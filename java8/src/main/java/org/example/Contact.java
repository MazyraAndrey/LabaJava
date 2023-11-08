package org.example;

public class Contact {

        private String name;
        private String surname;
        private int age;
        private String number;

        public Contact(String name, String surname, int age, String number) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public int getAge() {
            return age;
        }

        public String getNumber() {
            return number;
        }
    }

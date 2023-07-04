package com.example.szfirstapplication.repositories

import com.example.szfirstapplication.models.Person

class PersonRepository {
    fun getAllPeople():List<Person>{
        return listOf(
            Person(1,"Bekhruz", "Abdullakhujaev",20),
            Person(2,"Ibrokhim", "Abdullakhujaev",24),
            Person(3,"Feruzabonu", "Abdullakhujaeva",19),
            Person(4,"Bibikhonim", "Abdullakhujaeva",13),
            Person(5,"Mo'mina", "Abdullakhujaeva",17),
            Person(6,"Firdavs", "Abdullakhujaev",14),
            Person(7,"Osiyo", "Abdullakhujaeva",2),
            Person(7,"Osiyo", "Abdullakhujaeva",2),
            Person(7,"Osiyo", "Abdullakhujaeva",2),
            Person(7,"Osiyo", "Abdullakhujaeva",2),
            Person(7,"Osiyo", "Abdullakhujaeva",2),
            Person(7,"Osiyo", "Abdullakhujaeva",2),
            Person(7,"Osiyo", "Abdullakhujaeva",2),
            Person(7,"Osiyo", "Abdullakhujaeva",2),
        )
    }
}
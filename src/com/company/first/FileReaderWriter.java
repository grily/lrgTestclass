package com.company.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter<T> {


    public List<Character> readFile(String path) throws IOException,FileNotFoundException {

        File file = new File(path);
        List<Character> list = new ArrayList<>();

        FileReader fr = new FileReader(file);
        int end = fr.read();
        while(end != -1){
            list.add((char) end);
            end = fr.read();
        }
        fr.close();
        return list;
    }
    public void writeToFile( List<Character> list, String path) throws IOException{
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        for(int i=0;i<list.size();i++){
            Object obj = list.get(i);

            fw.write((char)obj);
        }

        fw.close();

    }

    public static void main(String[] args) {
        FileReaderWriter<Character> frw = new FileReaderWriter();
        List<Character> list = new ArrayList<>();
//读文件
        try {
            String path = "/Users/lcj/code/lrg/lrgTestclass/第一次上课作业.txt";
            list = frw.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
//写文件
        try {
            String writepath = "/Users/lcj/code/lrg/lrgTestclass/第一次上课作业copy.txt";
            frw.writeToFile(list, writepath);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

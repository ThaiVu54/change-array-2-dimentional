package com.example.testall;

import com.example.testall.model.Item;
//import com.example.testall.repository.ItemRepository;
import com.example.testall.model.TestNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestAllApplication implements CommandLineRunner {
    //    @Autowired
//    ItemRepository itemRepository;
    public static void main(String[] args) {
        SpringApplication.run(TestAllApplication.class, args);
        int[][] array2D = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int columns = array2D[0].length; // Số lượng cột
        int rows = array2D.length; // Số lượng dòng

        // Tạo một mảng 1 chiều chứa các mảng mới, mỗi mảng mới đại diện cho một cột
        int[][] columnsArray = new int[columns][];

        // Trích xuất các phần tử từ mỗi cột và đưa vào các mảng mới
        for (int j = 0; j < columns; j++) {
            int[] column = new int[rows]; // Mảng mới đại diện cho cột
            for (int i = 0; i < rows; i++) {
                column[i] = array2D[i][j]; // Lấy phần tử từ cột j và dòng i
            }
            columnsArray[j] = column; // Thêm mảng mới vào mảng chứa các cột
        }

        // In các mảng mới đại diện cho các cột
        for (int[] column : columnsArray) {
            for (int element : column) {
                System.out.print(element + " ");
            }
            System.out.println();
        }


        List<TestNew> testNewList = new ArrayList<>();
        TestNew testNew1 = new TestNew(1,"anh","yeu","ems");
        TestNew testNew2 = new TestNew(2,"dao","truc","mai");
        TestNew testNew3 = new TestNew(3,"thanh","quynh","huyen");
        TestNew testNew4 = new TestNew(4,"van anh","lanh","thuy");
        testNewList.add(testNew1);
        testNewList.add(testNew2);
        testNewList.add(testNew3);
        testNewList.add(testNew4);
        TestNew[][] testNewArray = new TestNew[4][1];

        //trả ra mảng 2 chiều
        TestNew[][] updatedArray = addListTo2DArray(testNewArray, testNewList);

        TestNew testNew = new TestNew();
        for (TestNew[] row : testNewArray) {
            for (TestNew testNewi : row) {
                System.out.println(testNewi);
            }
        }

    }
    public static TestNew[][] addListTo2DArray(TestNew[][] array, List<TestNew> list) {
        int rows = array.length;
        int cols = array[0].length;
        int index = 0;

        // Tạo một bản sao của mảng hai chiều ban đầu để tránh thay đổi mảng ban đầu
        TestNew[][] newArray = new TestNew[rows][cols];

        // Sao chép tất cả các phần tử từ mảng ban đầu vào mảng mới
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newArray[i][j] = array[i][j];
            }
        }

        // Duyệt qua mảng hai chiều mới và thêm các đối tượng từ danh sách vào
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < list.size()) {
                    newArray[i][j] = list.get(index++);
                } else {
                    return newArray; // Trả về mảng hai chiều mới nếu danh sách đã được thêm vào mảng
                }
            }
        }
        return newArray; // Trả về mảng hai chiều mới sau khi thêm tất cả các đối tượng từ danh sách
    }

    //    @Override
    public void run(String... args) throws Exception {
//
//        itemRepository.save(new Item("Item 1"));
//        itemRepository.save(new Item("Item 2"));
//        itemRepository.save(new Item("Item 3"));
//        itemRepository.save(new Item("Item 4"));
//        itemRepository.save(new Item("Item 5"));
    }
}

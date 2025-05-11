/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolist;

public class TaskModel {

    public int getId() {
        return idl;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
    
    private int idl;
    private String name, status;

    public TaskModel(int idl, String name, String status) {
        this.idl = idl;
        this.name = name;
        this.status = status;
    }
    
}

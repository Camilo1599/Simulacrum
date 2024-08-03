package com.riwi;

import com.riwi.persistences.configDB.MysqlConfig;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MysqlConfig.openConnection();
        MysqlConfig.closeConnection();
    }
}
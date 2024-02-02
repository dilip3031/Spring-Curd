package com.dileep.curd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "employee")
public class EmployeeEntity extends RootEntity {
    @Column
    String name;
    @Column
    String email;
    @Column
    Integer age;
    @Column
    Long salary;
    @Column
    Double experience;
}

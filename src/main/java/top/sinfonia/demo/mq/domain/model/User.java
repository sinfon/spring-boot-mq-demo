package top.sinfonia.demo.mq.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author singoasher
 * @date 2018/6/25
 */
@Data
public class User implements Serializable {
    private String name;
    private Integer age;
}

package com.learn.blog.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users") 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//@Column(name= "user_name", nullable = false, length=100) Here name is used to change the column name as user_name and 
	//nullable = false represents name is not null.
	@NotEmpty
	@Size(min=4, message="Username must be of min 4 characters!!")
	private String name;

	@Email(message="Email address is not valid!!")
	private String email;
	
	@NotEmpty
	@Size(min =3, message ="Password must be min of 3 characters and max of 10 characters !!")
	private String password;
	
	@NotEmpty
	private String about;
	
	// will add role later when required for authentication
}

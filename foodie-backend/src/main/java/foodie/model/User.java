package foodie.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	// @Column(nullable = false)
	private String username;

	@JsonIgnore
	private String password;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Email
	@Column(nullable = false)
	private String email;

	private String imageUrl;

	private String phoneNumber;
	
	private String address;

	@Column(nullable = false, columnDefinition = "BOOLEAN")
	private Boolean emailVerified = false;

	@NotNull
	@Enumerated(EnumType.STRING)
	private foodie.model.AuthProvider provider;

	@ManyToOne // (cascade = CascadeType.MERGE)
	private Role role;

	private String providerId;

	@CreatedDate
	private Date createdDate;

}
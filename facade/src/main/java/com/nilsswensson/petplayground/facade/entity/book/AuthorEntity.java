package com.nilsswensson.petplayground.facade.entity.author;

import com.nilsswensson.petplayground.facade.entity.book.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
public class AuthorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
  @SequenceGenerator(name = "author_id_seq", sequenceName = "author_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "date_of_birth")
  private LocalDateTime dateOfBirth;

  @ManyToMany(mappedBy = "authors")
  private Set<BookEntity> books;
}

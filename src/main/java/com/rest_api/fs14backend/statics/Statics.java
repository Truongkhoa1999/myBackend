package com.rest_api.fs14backend.statics;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "statics")
@Table(name = "statics")
@Data
@NoArgsConstructor
public class Statics {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID statId;
    @Column(nullable = true,columnDefinition = "integer default 0")
    private int clicks;
    @Column(nullable = true,columnDefinition = "integer default 0")
    private int rating;

    @Column(nullable = true)
    private LocalDateTime createdAt;


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

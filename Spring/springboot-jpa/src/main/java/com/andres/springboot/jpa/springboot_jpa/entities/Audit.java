package com.andres.springboot.jpa.springboot_jpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Audit {


 //variable para insertar en el prepersis y update
    @Column(name="create_at")// nombre que estan en la db
    private LocalDateTime creatAt;
    @Column(name="updated_at")
    private LocalDateTime updateAt;



        @PrePersist
    public void prePersist(){
        System.out.println("EVENTO DEL CICLO DE VIDA DEL prepersits");
        this.creatAt=LocalDateTime.now();
    }

    @PreUpdate
    public void preUdate(){
        System.out.println("EVENTO DEL CICLO DE VIDA DEL preUpdate");
        this.updateAt=LocalDateTime.now();
    }


    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

}

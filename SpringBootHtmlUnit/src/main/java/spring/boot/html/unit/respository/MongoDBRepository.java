package spring.boot.html.unit.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.boot.html.unit.domain.Band;

public interface MongoDBRepository extends MongoRepository<Band, String> {

}

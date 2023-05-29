package studyjava.boi.rent.service;

import studyjava.boi.rent.entity.Adress;

import java.util.List;

public interface AdressService {

    List<Adress> getAllAdress();

    Adress saveAdress(Adress adress);

    Adress findAdress(Adress adress);

}

package com.saraya.epharmacy.service.order_service;

import com.saraya.epharmacy.dto.order_dto.OrderDto;
import com.saraya.epharmacy.mapper.order_mapper.OrderMapper;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.modele.order_modele.Order;
import com.saraya.epharmacy.repository.order_repo.OrderRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import com.saraya.epharmacy.service.medecine_service.MedecineService;
import com.saraya.epharmacy.service.patient_service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements ServiceManagements<Order, OrderDto> {

    private final OrderRepo repo;
    private final MedecineService medecineService;
    private final PatientService patientService;

    private final OrderMapper mapper;

    public OrderService(OrderRepo repo, MedecineService medecineService, PatientService patientService, OrderMapper mapper) {
        this.repo = repo;
        this.medecineService = medecineService;
        this.patientService = patientService;
        this.mapper = mapper;
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        double total = 0;
        for (Medecine medecine: orderDto.getPatient().getMedecines()) {
             total += medecine.getPrix();
        }
        orderDto.setTotalPay(total);
        return mapper.toDto(repo.save(mapper.toEntity(orderDto)));
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public OrderDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<OrderDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        return mapper.toDto(repo.save(mapper.toEntity(orderDto)));
    }

    public Order afficheOrderPatient(int idPatient) {
        Order orderPatient = new Order();
        for (Order order : repo.findAll()) {
            if (order.getPatient().getId() == idPatient){
                orderPatient = order;
                break;
            }

        }
        return orderPatient;
    }
}

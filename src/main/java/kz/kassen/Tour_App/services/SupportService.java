package kz.kassen.Tour_App.services;

import kz.kassen.Tour_App.models.SupportModel;
import kz.kassen.Tour_App.repo.SupportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportService {
    private final SupportRepository supportRepository;

    public SupportService(SupportRepository supportRepository) {
        this.supportRepository = supportRepository;
    }

    public List<SupportModel> getAllSupports() {
        return supportRepository.findAll();
    }

    public void saveSupport(SupportModel support) {
        supportRepository.save(support);
    }
}

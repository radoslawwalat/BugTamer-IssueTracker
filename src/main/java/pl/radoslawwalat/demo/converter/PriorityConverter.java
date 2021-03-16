package pl.radoslawwalat.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.radoslawwalat.demo.model.Priority;
import pl.radoslawwalat.demo.repository.PriorityRepository;

public class PriorityConverter implements Converter<String, Priority> {


    private PriorityRepository priorityRepository;

    @Autowired
    public PriorityConverter(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public Priority convert(String s) {
        return priorityRepository.findById(Long.parseLong(s)).get();
    }


}

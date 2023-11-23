package uz.yangaliev.functions.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.yangaliev.functions.calculator.SmilesErasureCalculator;
import uz.yangaliev.functions.service.interfaces.SmilesErasureService;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SmilesErasureServiceImpl implements SmilesErasureService {

    private final SmilesErasureCalculator smilesErasure;

    @Override
    public Map<String, String> getResult(String[] strings) {
        Map<String, String> result = new HashMap<>();
        for (String string : strings) {
            result.put(string, smilesErasure.erasureSmiles(string));
        }
        return result;
    }
}

package mx.edu.utez.rismotorolos.stock.service;

import mx.edu.utez.rismotorolos.stock.model.Stock;
import mx.edu.utez.rismotorolos.stock.model.StockDto;
import mx.edu.utez.rismotorolos.stock.model.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock createStock(StockDto stockDto) {
        Stock stock = stockDto.toEntity();
        return stockRepository.save(stock);
    }

    public List<StockDto> getAllStocks() {
        return stockRepository.findAll().stream()
                .map(StockDto::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<StockDto> getStockById(Long id) {
        return stockRepository.findById(id).map(StockDto::fromEntity);
    }

    public Optional<StockDto> updateStock(Long id, StockDto stockDto) {
        return stockRepository.findById(id)
                .map(existingStock -> {
                    existingStock.setAmount(stockDto.getAmount());
                    existingStock.setFacture(stockDto.getFacture());
                    existingStock.setItem(stockDto.getItem());
                    stockRepository.save(existingStock);
                    return StockDto.fromEntity(existingStock);
                });
    }

    public boolean deleteStock(Long id) {
        if (stockRepository.existsById(id)) {
            stockRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

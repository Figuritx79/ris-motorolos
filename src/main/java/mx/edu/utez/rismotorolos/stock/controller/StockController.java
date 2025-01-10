package mx.edu.utez.rismotorolos.stock.controller;

import mx.edu.utez.rismotorolos.stock.model.StockDto;
import mx.edu.utez.rismotorolos.stock.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<StockDto> createStock(@RequestBody StockDto stockDto) {
        return ResponseEntity.ok(StockDto.fromEntity(stockService.createStock(stockDto)));
    }

    @GetMapping
    public ResponseEntity<List<StockDto>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> getStockById(@PathVariable Long id) {
        Optional<StockDto> stockDto = stockService.getStockById(id);
        return stockDto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockDto> updateStock(@PathVariable Long id, @RequestBody StockDto stockDto) {
        Optional<StockDto> updatedStock = stockService.updateStock(id, stockDto);
        return updatedStock.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        if (stockService.deleteStock(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

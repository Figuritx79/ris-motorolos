package mx.edu.utez.rismotorolos.item.service;

import mx.edu.utez.rismotorolos.item.model.Item;
import mx.edu.utez.rismotorolos.item.model.ItemDto;
import mx.edu.utez.rismotorolos.item.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(ItemDto itemDto) {
        return itemRepository.save(itemDto.toEntity());
    }

    public List<ItemDto> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<ItemDto> getItemById(Long id) {
        return itemRepository.findById(id)
                .map(ItemDto::fromEntity);
    }

    public Optional<ItemDto> updateItem(Long id, ItemDto itemDto) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item item = existingItem.get();
            item.setMedicine_name(itemDto.getmedicine_name());
            item.setDescription(itemDto.getDescription());
            item.setPrice(itemDto.getPrice());
            return Optional.of(ItemDto.fromEntity(itemRepository.save(item)));
        }
        return Optional.empty();
    }

    public boolean deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package mx.edu.utez.rismotorolos.item.service;

import mx.edu.utez.rismotorolos.item.model.Item;
import mx.edu.utez.rismotorolos.item.model.ItemDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();

    public Item createItem(ItemDto itemDto) {
        Item item = itemDto.toEntity();
        items.add(item);
        return item;
    }

    public List<ItemDto> getAllItems() {
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items) {
            itemDtos.add(ItemDto.fromEntity(item));
        }
        return itemDtos;
    }

    public Optional<ItemDto> getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .map(ItemDto::fromEntity);
    }

    public Optional<Item> updateItem(Long id, ItemDto itemDto) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .map(existingItem -> {
                    existingItem.setMedicine_name(itemDto.getmedicine_name());
                    existingItem.setDescription(itemDto.getDescription());
                    existingItem.setPrice(itemDto.getPrice());
                    return existingItem;
                });
    }

    public boolean deleteItem(Long id) {
        return items.removeIf(item -> item.getId().equals(id));
    }
}

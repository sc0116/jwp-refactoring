package kitchenpos.menugroup.presentation;

import kitchenpos.menugroup.application.MenuGroupService;
import kitchenpos.menugroup.application.dto.MenuGroupRequest;
import kitchenpos.menugroup.domain.MenuGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class MenuGroupRestController {
    private final MenuGroupService menuGroupService;

    public MenuGroupRestController(final MenuGroupService menuGroupService) {
        this.menuGroupService = menuGroupService;
    }

    @PostMapping("/api/menu-groups")
    public ResponseEntity<MenuGroup> create(@RequestBody final MenuGroupRequest menuGroupRequest) {
        final MenuGroup createdMenuGroup = menuGroupService.create(menuGroupRequest);
        final URI uri = URI.create("/api/menu-groups/" + createdMenuGroup.getId());
        return ResponseEntity.created(uri)
                .body(createdMenuGroup)
                ;
    }

    @GetMapping("/api/menu-groups")
    public ResponseEntity<List<MenuGroup>> list() {
        return ResponseEntity.ok()
                .body(menuGroupService.list())
                ;
    }
}

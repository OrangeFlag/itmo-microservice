package org.dei.storehouse.controller;

import org.dei.storehouse.api.StorehouseAPI;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouse")
interface StoreHouseController extends StorehouseAPI {
}

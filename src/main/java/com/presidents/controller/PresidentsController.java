package com.presidents.controller;


import com.presidents.model.dto.PresidentDto;
import com.presidents.service.president.PresidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("presidents")
@RequiredArgsConstructor
public class PresidentsController {

    private final PresidentService presidentService;
    @GetMapping("all")
    public List<PresidentDto> getAll() {
        return presidentService.getAllPresidents();
    }

    @PostMapping ("save")
    @ResponseStatus(HttpStatus.CREATED)
    public PresidentDto savePresident(@Valid @RequestBody PresidentDto presidentDto) {
        return presidentService.savePresident(presidentDto);
    }
//     exception rozpisany w celach dydaktycznych
//    @ExceptionHandler({RuntimeException.class, IllegalAccessError.class})
//    public final ResponseEntity<Object> handleExceptions(Exception ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @PutMapping("update")
    public PresidentDto updateWithBodyOnly(@Valid @RequestBody PresidentDto presidentDto) {
        return presidentService.updatePresident(presidentDto);

    }

    @PatchMapping("update")
    public PresidentDto updatePartial(@RequestBody PresidentDto presidentDto) {
        return presidentService.updatePresidentPartial(presidentDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteByIndex(@PathVariable Long id){
        presidentService.deletePresident(id);
    }

    @GetMapping("find-by-name/{name}")
    public Set<PresidentDto> getPresidentsByName(@PathVariable String name) {
        return presidentService.findPresidentsByName(name);
    }

    @GetMapping("find-by-party/{party}")
    public Set<PresidentDto> getPresidentsByPoliticalParty(@PathVariable String party) {
        return presidentService.findPresidentsByPoliticalParty(party);
    }
}

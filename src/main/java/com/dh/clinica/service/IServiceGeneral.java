package com.dh.clinica.service;

import java.util.List;

public interface IServiceGeneral<T> {
    T guardar(T t);
    List<T> buscarTodos();
    T buscarPorId(Integer id);
    T actualizar (T t);
    void borrar(Integer id);
}
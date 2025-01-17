package ru.pulsar.jenkins.library.configuration

import com.cloudbees.groovy.cps.NonCPS
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonPropertyDescription

@JsonIgnoreProperties(ignoreUnknown = true)
class StageFlags implements Serializable {
    @JsonPropertyDescription("Анализ SonarQube включен")
    Boolean sonarqube

    @JsonPropertyDescription("Синтаксический контроль включен")
    Boolean syntaxCheck

    @JsonPropertyDescription("Валидация EDT включена")
    Boolean edtValidate

    @JsonPropertyDescription("Дымовые тесты включены")
    Boolean smoke

    @JsonPropertyDescription("Предварительные шаги инициализации включены")
    Boolean initSteps

    @JsonPropertyDescription("Запуск BDD сценариев включен")
    Boolean bdd

    @JsonPropertyDescription("Выполнять рассылку результатов сборки на email")
    Boolean email

    @JsonPropertyDescription("Выполнять рассылку результатов сборки в telegram")
    Boolean telegram

    @JsonPropertyDescription("Выполнять формирование файла поставки")
    Boolean createDistributive

    @Override
    @NonCPS
    String toString() {
        return "StageFlags{" +
            "sonarqube=" + sonarqube +
            ", syntaxCheck=" + syntaxCheck +
            ", edtValidate=" + edtValidate +
            ", smoke=" + smoke +
            ", initSteps=" + initSteps +
            ", bdd=" + bdd +
            ", email=" + email +
            ", telegram=" + telegram +
            ", createDistributive=" + createDistributive +
            '}';
    }

    boolean needInfoBase() {
        return smoke || syntaxCheck || initSteps || bdd || createDistributive
    }
}

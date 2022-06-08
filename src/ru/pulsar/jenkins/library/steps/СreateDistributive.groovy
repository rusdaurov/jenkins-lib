package ru.pulsar.jenkins.library.steps

import ru.pulsar.jenkins.library.IStepExecutor
import ru.pulsar.jenkins.library.configuration.JobConfiguration
import ru.pulsar.jenkins.library.ioc.ContextRegistry
import ru.pulsar.jenkins.library.utils.Logger

class СreateDistributive implements Serializable {

    private final JobConfiguration config;

    СreateDistributive(JobConfiguration config) {
        this.config = config
    }

    def run() {
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        Logger.printLocation()

        // if (!config.stageFlags.createDistributive) {
        //     Logger.println("Сreate distributive step is disabled")
        //     return
        // }

        def env = steps.env();

        Logger.println("Выполнение формирование поставки")

        steps.cmd("packman set-database \"/F$env.WORKSPACE/build/ib\"")
        steps.cmd("packman make-cf -v8version $config.v8version")
        steps.cmd("packman make-dist ./Манифест.edf -setup -v8version $config.v8version")
        steps.cmd("packman zip-dist -out $env.WORKSPACE/build")

        steps.archiveArtifacts("build/dist*.zip")

    }
}

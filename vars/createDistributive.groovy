import ru.pulsar.jenkins.library.configuration.JobConfiguration
import ru.pulsar.jenkins.library.ioc.ContextRegistry
import ru.pulsar.jenkins.library.steps.СreateDistributive

def call(JobConfiguration config) {
    ContextRegistry.registerDefaultContext(this)

    def createDistributive = new СreateDistributive(config)
    createDistributive.run()
}

package hu.bme.iemqra.mobsoft.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.InteractorModule;
import hu.bme.iemqra.mobsoft.mobsoft.mock.MockNetworkModule;
import hu.bme.iemqra.mobsoft.mobsoft.repository.RepositoryModule;
import hu.bme.iemqra.mobsoft.mobsoft.repository.TestRepositoryModule;
import hu.bme.iemqra.mobsoft.mobsoft.ui.UIModule;

/**
 * Created by czegl on 2017. 05. 15..
 */

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}

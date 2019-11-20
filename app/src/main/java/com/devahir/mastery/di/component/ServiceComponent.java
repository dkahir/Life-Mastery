

package com.devahir.mastery.di.component;

import com.devahir.mastery.di.PerService;
import com.devahir.mastery.di.module.ServiceModule;
import com.devahir.mastery.service.SyncService;
import dagger.Component;


@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}

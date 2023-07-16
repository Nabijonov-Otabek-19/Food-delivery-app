package uz.gita.fooddeliveryapp_bek.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.fooddeliveryapp_bek.domain.repository.AuthRepository
import uz.gita.fooddeliveryapp_bek.domain.repository.RoomRepository
import uz.gita.fooddeliveryapp_bek.domain.repository.ShopRepository
import uz.gita.fooddeliveryapp_bek.domain.repository.impl.AuthRepositoryImpl
import uz.gita.fooddeliveryapp_bek.domain.repository.impl.RoomRepositoryImpl
import uz.gita.fooddeliveryapp_bek.domain.repository.impl.ShopRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @[Binds Singleton]
    fun bindShopRepository(impl: ShopRepositoryImpl): ShopRepository

    @[Binds Singleton]
    fun bindRoomRepository(impl: RoomRepositoryImpl): RoomRepository
}